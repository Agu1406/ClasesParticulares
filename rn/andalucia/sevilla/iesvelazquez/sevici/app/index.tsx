import { useEffect } from 'react';
import { useRouter } from 'expo-router';

export default function Index() {
  const router = useRouter();

  useEffect(() => {
    // Redirigir al login al iniciar la app
    router.replace('/(auth)/login');
  }, []);

  return null;
}

