const express = require('express');
const http = require('http');
const morgan = require('morgan');
const bodyParser = require('body-parser');

const dishRouter = require('./routes/dishRouter');
const leaderRouter = require('./routes/leaderRouter');
const promoRouter = require('./routes/promoRouter');

const hostname = 'localhost';
const port = process.env.PORT || '5000';

const app = express();
app.use(morgan('dev'));
app.use(bodyParser.json());

app.use('/dishes', dishRouter);
app.use('/leaders', leaderRouter);
app.use('/promotions', promoRouter);

app.get('/', (req, res) => {
	res.send('Hello');
});

app.use(express.static(__dirname + '/public'));

app.use((req, res, next) => {
	res.statusCode = 200;
	res.setHeader('Content-Type', 'text/html');
	res.end('<html><body><h1>This is an Express Server</h1></body></html>');
});

const server = http.createServer(app);

app.listen(port, () => {
	console.log(`Server running on Port ${port}`);
});
