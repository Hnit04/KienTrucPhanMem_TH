# --- Stage 1: Build React app ---
FROM node:18 AS builder
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm ci
COPY . .
RUN npm run build

# --- Stage 2: Serve with Nginx ---
FROM nginx:stable-alpine
# Copy static build từ builder
COPY --from=builder /app/build /usr/share/nginx/html
# Copy cấu hình Nginx
COPY ../nginx/default.conf /etc/nginx/conf.d/default.conf
# Expose port 80
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
