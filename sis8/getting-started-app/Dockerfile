# syntax=docker/dockerfile:1

FROM node:lts-alpine

# Рабочая директория внутри контейнера
WORKDIR /app

# Копируем всё приложение
COPY . .

# Устанавливаем зависимости
RUN yarn install --production

# Команда по умолчанию
CMD ["node", "src/index.js"]

# Экспонируем порт приложения
EXPOSE 3000