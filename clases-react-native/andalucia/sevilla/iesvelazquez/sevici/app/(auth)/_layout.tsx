import { Stack } from 'expo-router';
import { Colors } from '../../constants/colors';

export default function AuthLayout() {
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
        name="login" 
        options={{ 
          headerShown: false 
        }} 
      />
      <Stack.Screen 
        name="register-step1" 
        options={{ 
          title: 'Crear Cuenta',
          headerBackTitle: 'Atrás'
        }} 
      />
      <Stack.Screen 
        name="register-step2" 
        options={{ 
          title: 'Crear Cuenta',
          headerBackTitle: 'Atrás'
        }} 
      />
    </Stack>
  );
}

