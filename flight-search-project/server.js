const express = require('express');
const request = require('request');
const app = express();
const path = require('path');

app.use(express.static(path.join(__dirname, 'public')));


app.post('/api/auth/login', (req, res) => {
    req.pipe(request.post('http://localhost:8080/auth/login', { json: req.body })).pipe(res);
});


app.post('/api/flights/search', (req, res) => {
    req.pipe(request.post('http://localhost:8081/flights/search', { json: req.body })).pipe(res);
});


app.post('/api/reservations/create', (req, res) => {
    req.pipe(request.post('http://localhost:8082/reservations/create', { json: req.body })).pipe(res);
});


app.post('/reservations/ticket', (req, res) => {
    req.pipe(request.post('http://localhost:8083/reservations/ticket', { json: req.body })).pipe(res);
});


app.post('/api/cancellation', (req, res) => {
    req.pipe(request.post('http://localhost:8084/api/cancellation', { json: req.body })).pipe(res);
});


app.post('/api/reservation-search', (req, res) => {
    req.pipe(request.post('http://localhost:8085/api/reservation-search', { json: req.body })).pipe(res);
});

const port = 3000;
app.listen(port, () => {
    console.log(`Server running on http://localhost:${port}`);
});
