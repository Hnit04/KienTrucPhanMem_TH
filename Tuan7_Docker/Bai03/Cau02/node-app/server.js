const express = require('express');
const mongoose = require('mongoose');

const app = express();
const port = 3000;

// Middleware để parse JSON
app.use(express.json());

// Kết nối tới MongoDB
const mongoUri = process.env.MONGO_URI || 'mongodb://mongo:27017/mydb';
mongoose.connect(mongoUri, { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => console.log('Connected to MongoDB'))
  .catch(err => console.error('MongoDB connection error:', err));

// Định nghĩa schema và model
const itemSchema = new mongoose.Schema({
  name: String,
  description: String
});
const Item = mongoose.model('Item', itemSchema);

// Route để lưu item
app.post('/items', async (req, res) => {
  try {
    const item = new Item(req.body);
    await item.save();
    res.status(201).json(item);
  } catch (err) {
    res.status(400).json({ error: err.message });
  }
});

// Route để lấy tất cả items
app.get('/items', async (req, res) => {
  try {
    const items = await Item.find();
    res.json(items);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Khởi động server
app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});