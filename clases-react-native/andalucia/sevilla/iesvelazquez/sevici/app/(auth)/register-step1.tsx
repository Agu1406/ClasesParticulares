import React, { useState } from 'react';
import { View, Text, TextInput, TouchableOpacity, StyleSheet, Image, KeyboardAvoidingView, Platform, ScrollView } from 'react-native';
import { Formik } from 'formik';
import { useRouter } from 'expo-router';
import { registerStep1Schema } from '../../utils/validation';
import { storage } from '../../utils/storage';
import { ErrorModal } from '../../components/ErrorModal';
import { Colors } from '../../constants/colors';

export default function RegisterStep1Screen() {
  const router = useRouter();
  const [errorModal, setErrorModal] = useState({ visible: false, title: '', message: '' });

  return (
    <KeyboardAvoidingView 
      style={styles.container}
      behavior={Platform.OS === 'ios' ? 'padding' : 'height'}
    >
      <ScrollView contentContainerStyle={styles.scrollContent}>
        <View style={styles.content}>
          {/* Imagen de registro */}
          <Image 
            source={require('../../assets/images/registro.png')} 
            style={styles.image}
            resizeMode="cover"
          />

          <Formik
            initialValues={{ email: '', username: '' }}
            validationSchema={registerStep1Schema}
            onSubmit={async (values, { setSubmitting }) => {
              try {
                // Verificar si el usuario ya existe
                const exists = await storage.userExists(values.email);
                if (exists) {
                  setErrorModal({
                    visible: true,
                    title: '¿YA NOS CONOCEMOS?',
                    message: 'Este correo electrónico ya está en uso. Por favor, compruébalo o inicia sesión.'
                  });
                  setSubmitting(false);
                  return;
                }

                // Guardar los datos en AsyncStorage
                await storage.saveUserData(values.email, values.username);
                
                // Navegar al paso 2
                router.push('/(auth)/register-step2');
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

                {/* Campo Nombre de Usuario */}
                <TextInput
                  style={styles.input}
                  placeholder="Nombre de usuario"
                  value={values.username}
                  onChangeText={handleChange('username')}
                  onBlur={handleBlur('username')}
                  autoCapitalize="none"
                />
                {touched.username && errors.username && (
                  <Text style={styles.errorText}>{errors.username}</Text>
                )}

                {/* Botón Siguiente */}
                <TouchableOpacity 
                  style={styles.button} 
                  onPress={() => handleSubmit()}
                >
                  <Text style={styles.buttonText}>SIGUIENTE</Text>
                </TouchableOpacity>
              </View>
            )}
          </Formik>
        </View>
      </ScrollView>

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
  scrollContent: {
    flexGrow: 1,
  },
  content: {
    flex: 1,
    padding: 20,
  },
  image: {
    width: '100%',
    height: 200,
    marginBottom: 30,
    borderRadius: 10,
  },
  form: {
    width: '100%',
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
  button: {
    backgroundColor: Colors.primary,
    paddingVertical: 15,
    borderRadius: 25,
    alignItems: 'center',
    marginTop: 20,
  },
  buttonText: {
    color: Colors.secondary,
    fontSize: 16,
    fontWeight: 'bold',
  },
});

