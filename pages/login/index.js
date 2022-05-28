import Head from 'next/head';
import Login from '../../components/login';

export default function LoginPage() {
	return (
		<div>
			<Head>
				<title>Login</title>
			</Head>
			<Login />
		</div>
	);
}
