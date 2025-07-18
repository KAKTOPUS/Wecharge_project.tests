#!/bin/bash

# Определяем конфигурации для тестовых классов
declare -A TEST_CONFIGS=(
  ["Smoke_Tests"]="fullscreen"
)

# Базовые параметры
BASE_URL="https://apanel.wechargers.com"
REMOTE_URL=""
BROWSER="firefox"
VERSION=""

# Функция запуска тестов с параметрами
run_test_class() {
  local test_class=$1
  local launch_param=$2

  echo "--------------------------------------------------"
  echo "Запуск тестового класса: $test_class"
  echo "Параметр запуска: $launch_param"
  echo "--------------------------------------------------"

  mvn test \
    -Dbrowser="$BROWSER" \
    -Dlaunch-parameter="$launch_param" \
    -Dbrowser-version="$VERSION" \
    -Dbase-url="$BASE_URL" \
    -Dremote-url="$REMOTE_URL" \
    -Dtest="$test_class"
}

# Основной цикл запуска
for test_class in "${!TEST_CONFIGS[@]}"; do
  launch_param="${TEST_CONFIGS[$test_class]}"

# Запускаем в фоновом режиме для параллельного выполнения
  run_test_class "$test_class" "$launch_param" &
done

# Ждем завершения всех тестов
wait

echo "Все тесты завершены"

# Генерируем отчет Allure
allure serve allure-results/