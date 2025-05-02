# Sử dụng image Node.js chính thức
FROM node:18

# Tạo thư mục làm việc
WORKDIR /usr/src/app

# Sao chép package.json và cài đặt dependencies
COPY package.json ./
RUN npm install

# Sao chép mã nguồn
COPY . .

# Mở cổng 3000
EXPOSE 3000

# Lệnh chạy ứng dụng
CMD ["node", "server.js"]