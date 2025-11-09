import AsyncStorage from '@react-native-async-storage/async-storage';

const USER_KEY = '@sevici_user';
const EMAIL_KEY = '@sevici_email';
const PIN_KEY = '@sevici_pin';

export const storage = {
  // Guardar datos de usuario
  saveUserData: async (email: string, username: string) => {
    try {
      await AsyncStorage.setItem(EMAIL_KEY, email);
      await AsyncStorage.setItem(USER_KEY, username);
    } catch (error) {
      console.error('Error guardando datos:', error);
    }
  },

  // Obtener nombre de usuario
  getUsername: async (): Promise<string | null> => {
    try {
      return await AsyncStorage.getItem(USER_KEY);
    } catch (error) {
      console.error('Error obteniendo usuario:', error);
      return null;
    }
  },

  // Obtener email
  getEmail: async (): Promise<string | null> => {
    try {
      return await AsyncStorage.getItem(EMAIL_KEY);
    } catch (error) {
      console.error('Error obteniendo email:', error);
      return null;
    }
  },

  // Guardar PIN
  savePIN: async (pin: string) => {
    try {
      await AsyncStorage.setItem(PIN_KEY, pin);
    } catch (error) {
      console.error('Error guardando PIN:', error);
    }
  },

  // Verificar credenciales (simulado)
  verifyCredentials: async (email: string, pin: string): Promise<boolean> => {
    try {
      const storedEmail = await AsyncStorage.getItem(EMAIL_KEY);
      const storedPIN = await AsyncStorage.getItem(PIN_KEY);
      return storedEmail === email && storedPIN === pin;
    } catch (error) {
      return false;
    }
  },

  // Verificar si el usuario existe
  userExists: async (email: string): Promise<boolean> => {
    try {
      const storedEmail = await AsyncStorage.getItem(EMAIL_KEY);
      return storedEmail === email;
    } catch (error) {
      return false;
    }
  },
};

