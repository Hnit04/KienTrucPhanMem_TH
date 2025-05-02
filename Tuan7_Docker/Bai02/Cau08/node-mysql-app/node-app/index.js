const express = require('express');
const mysql = require('mysql2');
const app = express();
const port = 3000;

const db = mysql.createConnection({
  host: process.env.DB_HOST,
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_NAME,
});

db.connect(err => {
  if (err) {
    console.error('❌ Cannot connect to database:', err);
  } else {
    console.log('✅ Connected to MySQL!');
  }
});

app.get('/', (req, res) => {
  db.query('SELECT NOW() as now', (err, results) => {
    if (err) return res.status(500).send(err);
    res.send(`Database time: ${results[0].now}`);
  });
});

app.listen(port, () => {
  console.log(`🚀 Server running at http://localhost:${port}`);
});
