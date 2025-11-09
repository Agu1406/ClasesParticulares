import { Stack } from 'expo-router';
import { Colors } from '../constants/colors';

export default function RootLayout() {
  return (
    <Stack
      screenOptions={{
        headerStyle: {
          backgroundColor: Colors.primary,
        },
        headerTintColor: Colors.secondary,
        headerTitleStyle: {
          fontWeight: 'bold',
        },
      }}
    >
      <Stack.Screen 
        name="(auth)/login" 
        options={{ 
          headerShown: false,
          title: 'Login'
        }} 
      />
      <Stack.Screen 
        name="(auth)/register-step1" 
        options={{ 
          title: 'Crear Cuenta',
          headerBackTitle: 'Atrás'
        }} 
      />
      <Stack.Screen 
        name="(auth)/register-step2" 
        options={{ 
          title: 'Crear Cuenta',
          headerBackTitle: 'Atrás'
        }} 
      />
      <Stack.Screen 
        name="(tabs)" 
        options={{ 
          headerShown: false 
        }} 
      />
    </Stack>
  );
}
