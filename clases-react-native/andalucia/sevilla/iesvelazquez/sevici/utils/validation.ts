import * as Yup from 'yup';

// Esquema de validación para Login
export const loginSchema = Yup.object().shape({
  email: Yup.string()
    .email('El correo electrónico debe tener un formato válido')
    .required('El correo electrónico es obligatorio')
    .test('email-format', 'El correo electrónico tiene que contener @ y .', (value) => {
      return value?.includes('@') && value?.includes('.');
    }),
  pin: Yup.string()
    .required('El código PIN es obligatorio')
    .length(6, 'El código PIN debe tener exactamente 6 dígitos')
    .matches(/^\d+$/, 'El código PIN debe ser numérico'),
});

// Esquema de validación para Registro Paso 1
export const registerStep1Schema = Yup.object().shape({
  email: Yup.string()
    .email('El correo electrónico debe tener un formato válido')
    .required('El correo electrónico es obligatorio')
    .test('email-format', 'El correo electrónico tiene que contener @ y .', (value) => {
      return value?.includes('@') && value?.includes('.');
    }),
  username: Yup.string()
    .required('El nombre de usuario es obligatorio')
    .min(3, 'El nombre de usuario debe tener al menos 3 caracteres'),
});

// Esquema de validación para Registro Paso 2
export const registerStep2Schema = Yup.object().shape({
  pin: Yup.string()
    .required('El código PIN es obligatorio')
    .length(6, 'El código PIN debe tener exactamente 6 dígitos')
    .matches(/^\d+$/, 'El código PIN debe ser numérico'),
});

