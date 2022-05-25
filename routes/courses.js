const express = require('express');
const bodyParser = require('body-parser');

const promoRouter = express.Router();

promoRouter.use(bodyParser.json());

promoRouter
	.route('/')
	.all((req, res, next) => {
		statusCode = 200;
		res.setHeader('Content-Type', 'text/plain');
		next();
	})
	.get((req, res, next) => {
		res.end('Will send all the promotions to you!');
	})
	.post((req, res, next) => {
		res.end(
			'Will add the promotion: ' +
				req.body.name +
				' with description: ' +
				req.body.description +
				' to you!'
		);
	})
	.put((req, res, next) => {
		statusCode = 403;
		res.end('PUT operation not supported on /promotions!');
	})
	.delete((req, res, next) => {
		res.end('Deleting all promotions!');
	});

promoRouter
	.route('/:promoId')
	.all((req, res, next) => {
		statusCode = 200;
		res.setHeader('Content-Type', 'text/plain');
		next();
	})
	.get((req, res, next) => {
		res.end(
			'Will send details of the promotion: ' + req.params.promoId + ' to you!'
		);
	})
	.put((req, res, next) => {
		statusCode = 403;
		res.end('PUT not supported in /promotions/' + req.params.promoId);
	})
	.post((req, res, next) => {
		res.write('Updating the promotion: ' + req.params.promoId + '\n');
		res.end(
			'Will update the promotion: ' +
				req.body.name +
				' with description: ' +
				req.body.description +
				' to you!'
		);
	})
	.delete((req, res, next) => {
		res.end('Deleting the promotion: ' + req.params.promoId);
	});

module.exports = promoRouter;
