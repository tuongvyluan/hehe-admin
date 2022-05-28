export default function getAllStudents(req, res) {
	if (req.method == 'GET') {
		res.status(200).json({ message: 'Get all students' });
	}
}
