import React, { useState } from 'react';
import { View, Text, TextInput, TouchableOpacity, StyleSheet, Image, KeyboardAvoidingView, Platform } from 'react-native';
import { Formik } from 'formik';
import { useRouter } from 'expo-router';
import { loginSchema } from '../../utils/validation';
import { storage } from '../../utils/storage';
import { ErrorModal } from '../../components/ErrorModal';
import { Colors } from '../../constants/colors';

export default function LoginScreen() {
  const router = useRouter();
  const [errorModal, setErrorModal] = useState({ visible: false, title: '', message: '' });

  return (
    <KeyboardAvoidingView 
      style={styles.container}
      behavior={Platform.OS === 'ios' ? 'padding' : 'height'}
    >
      <View style={styles.content}>
        {/* Logo */}
        <Image 
          source={require('../../assets/images/logo.png')} 
          style={styles.logo}
          resizeMode="contain"
        />

        <Formik
          initialValues={{ email: '', pin: '' }}
          validationSchema={loginSchema}
          onSubmit={async (values, { setSubmitting }) => {
            try {
              const isValid = await storage.verifyCredentials(values.email, values.pin);
              if (isValid) {
                router.push('/(tabs)/profile');
              } else {
                setErrorModal({
                  visible: true,
                  title: '¡UPS!',
                  message: 'Autenticación incorrecta. Por favor, compruebe su nombre de usuario y su código PIN.'
                });
              }
            } catch (error) {
              setErrorModal({
                visible: true,
                title: 'Error',
                message: 'Ha ocurrido un error. Por favor, inténtelo de nuevo.'
              });
            } finally {
              setSubmitting(false);
            }
          }}
        >
          {({ handleChange, handleBlur, handleSubmit, values, errors, touched }) => (
            <View style={styles.form}>
              {/* Campo Email */}
              <TextInput
                style={styles.input}
                placeholder="Correo electrónico"
                value={values.email}
                onChangeText={handleChange('email')}
                onBlur={handleBlur('email')}
                keyboardType="email-address"
                autoCapitalize="none"
              />
              {touched.email && errors.email && (
                <Text style={styles.errorText}>{errors.email}</Text>
              )}

              {/* Campo PIN */}
              <TextInput
                style={styles.input}
                placeholder="Código PIN (6 dígitos)"
                value={values.pin}
                onChangeText={handleChange('pin')}
                onBlur={handleBlur('pin')}
                secureTextEntry
                keyboardType="numeric"
                maxLength={6}
              />
              {touched.pin && errors.pin && (
                <Text style={styles.errorText}>{errors.pin}</Text>
              )}

              {/* Botón Iniciar Sesión */}
              <TouchableOpacity 
                style={styles.loginButton} 
                onPress={() => handleSubmit()}
              >
                <Text style={styles.loginButtonText}>INICIAR SESIÓN</Text>
              </TouchableOpacity>

              {/* Botón Crear Cuenta */}
              <TouchableOpacity 
                style={styles.registerButton}
                onPress={() => router.push('/(auth)/register-step1')}
              >
                <Text style={styles.registerButtonText}>CREAR MI CUENTA</Text>
              </TouchableOpacity>
            </View>
          )}
        </Formik>
      </View>

      {/* Modal de Error */}
      <ErrorModal
        visible={errorModal.visible}
        title={errorModal.title}
        message={errorModal.message}
        onClose={() => setErrorModal({ ...errorModal, visible: false })}
      />
    </KeyboardAvoidingView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: Colors.background,
  },
  content: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    padding: 20,
  },
  logo: {
    width: 200,
    height: 100,
    marginBottom: 40,
  },
  form: {
    width: '100%',
    maxWidth: 400,
  },
  input: {
    borderBottomWidth: 1,
    borderBottomColor: Colors.primary,
    paddingVertical: 12,
    paddingHorizontal: 10,
    marginBottom: 20,
    fontSize: 16,
  },
  errorText: {
    color: Colors.error,
    fontSize: 12,
    marginTop: -15,
    marginBottom: 10,
  },
  loginButton: {
    backgroundColor: Colors.primary,
    paddingVertical: 15,
    borderRadius: 25,
    alignItems: 'center',
    marginTop: 20,
  },
  loginButtonText: {
    color: Colors.secondary,
    fontSize: 16,
    fontWeight: 'bold',
  },
  registerButton: {
    backgroundColor: Colors.secondary,
    borderWidth: 1,
    borderColor: Colors.primary,
    paddingVertical: 15,
    borderRadius: 25,
    alignItems: 'center',
    marginTop: 15,
  },
  registerButtonText: {
    color: Colors.primary,
    fontSize: 16,
    fontWeight: 'bold',
  },
});

