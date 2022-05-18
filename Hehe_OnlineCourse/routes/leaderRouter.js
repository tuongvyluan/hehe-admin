const express = require('express');
const bodyParser = require('body-parser');

const leaderRouter = express.Router();

leaderRouter.use(bodyParser.json());

leaderRouter
	.route('/')
	.all((req, res, next) => {
		statusCode = 200;
		res.setHeader('Content-Type', 'text/plain');
		next();
	})
	.get((req, res, next) => {
		res.end('Will send all the leaders to you!');
	})
	.post((req, res, next) => {
		res.end(
			'Will add the leader: ' +
				req.body.name +
				' with description: ' +
				req.body.description +
				' to you!'
		);
	})
	.put((req, res, next) => {
		statusCode = 403;
		res.end('PUT operation not supported on /leaders!');
	})
	.delete((req, res, next) => {
		res.end('Deleting all leaders!');
	});

leaderRouter
	.route('/:leaderId')
	.all((req, res, next) => {
		statusCode = 200;
		res.setHeader('Content-Type', 'text/plain');
		next();
	})
	.get((req, res, next) => {
		res.end('Will send details of the leader: ' + req.params.leaderId + ' to you!');
	})
	.put((req, res, next) => {
		statusCode = 403;
		res.end('PUT not supported in /leaders/' + req.params.leaderId);
	})
	.post((req, res, next) => {
		res.write('Updating the leader: ' + req.params.leaderId + '\n');
		res.end(
			'Will update the leader: ' +
				req.body.name +
				' with description: ' +
				req.body.description +
				' to you!'
		);
	})
	.delete((req, res, next) => {
		res.end('Deleting the leader: ' + req.params.leaderId);
	});

module.exports = leaderRouter;
