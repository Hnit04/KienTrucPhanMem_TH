# Chọn image Node.js chính thức từ Docker Hub
FROM node:16

# Thiết lập thư mục làm việc trong container
WORKDIR /usr/src/app

# Sao chép package.json và package-lock.json vào container
COPY package*.json ./

# Cài đặt các dependencies
RUN npm install

# Sao chép toàn bộ mã nguồn vào container
COPY . .

# Mở cổng 3000 để ứng dụng có thể truy cập
EXPOSE 3000

# Chạy ứng dụng Node.js
CMD ["node", "app.js"]
