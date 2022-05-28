import Head from 'next/head';
import LearningPaths from '../../components/learning-paths';

export default function LoginPage() {
	return (
		<div>
			<Head>
				<title>Learning Paths</title>
			</Head>
			<LearningPaths />
		</div>
	);
}
