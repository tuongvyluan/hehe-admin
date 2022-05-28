export default function getStudentById(req, res) {
	if (req.method == 'GET') {
		res
			.status(200)
			.json({ byId: req.query.id, message: `Get student by ID: ${req.query.id}` });
	}
}
