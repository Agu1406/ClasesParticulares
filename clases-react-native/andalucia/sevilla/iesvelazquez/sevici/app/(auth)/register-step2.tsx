import React, { useState } from 'react';
import { View, Text, TextInput, TouchableOpacity, StyleSheet, Image, KeyboardAvoidingView, Platform, ScrollView } from 'react-native';
import { Formik } from 'formik';
import { useRouter } from 'expo-router';
import { registerStep2Schema } from '../../utils/validation';
import { storage } from '../../utils/storage';
import { ErrorModal } from '../../components/ErrorModal';
import { Colors } from '../../constants/colors';

export default function RegisterStep2Screen() {
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
            initialValues={{ pin: '' }}
            validationSchema={registerStep2Schema}
            onSubmit={async (values, { setSubmitting }) => {
              try {
                // Guardar el PIN en AsyncStorage
                await storage.savePIN(values.pin);
                
                // Navegar al login
                router.push('/(auth)/login');
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
                {/* Título */}
                <Text style={styles.title}>ELIGE TU PIN (6 DÍGITOS)</Text>

                {/* Campo PIN */}
                <TextInput
                  style={styles.input}
                  placeholder="Elige tu PIN (6 digitos)"
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

                {/* Texto de ayuda */}
                <Text style={styles.helpText}>
                  Tu PIN tiene que tener 6 digitos. No uses tu fecha de nacimiento
                </Text>

                {/* Botón Confirmar */}
                <TouchableOpacity 
                  style={styles.button} 
                  onPress={() => handleSubmit()}
                >
                  <Text style={styles.buttonText}>CONFIRMAR</Text>
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
  title: {
    fontSize: 20,
    fontWeight: 'bold',
    color: Colors.text,
    marginBottom: 20,
    textAlign: 'center',
  },
  helpText: {
    fontSize: 12,
    color: Colors.textSecondary,
    marginTop: 10,
    marginBottom: 20,
    textAlign: 'center',
  },
});

