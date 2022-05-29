import Head from 'next/head';
import Home from '../components/index';

export default function Homepage() {
	return (
		<div>
			<Head>
				<title>Hehe Courses</title>
			</Head>
			<Home />
		</div>
	);
}
