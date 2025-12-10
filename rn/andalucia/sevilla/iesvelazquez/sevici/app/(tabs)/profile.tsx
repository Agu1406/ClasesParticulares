import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet, Image, ScrollView } from 'react-native';
import { storage } from '../../utils/storage';
import { Colors } from '../../constants/colors';

export default function ProfileScreen() {
  const [username, setUsername] = useState<string>('');

  useEffect(() => {
    // Cargar el nombre de usuario al montar el componente
    const loadUsername = async () => {
      const user = await storage.getUsername();
      if (user) {
        setUsername(user);
      }
    };
    loadUsername();
  }, []);

  return (
    <ScrollView style={styles.container} contentContainerStyle={styles.content}>
      {/* Imagen de perfil */}
      <Image 
        source={require('../../assets/images/profile.png')} 
        style={styles.profileImage}
        resizeMode="contain"
      />

      {/* Nombre del usuario */}
      <Text style={styles.username}>{username || 'Usuario'}</Text>

      {/* Tarjetas opcionales (como en la imagen del examen) */}
      <View style={styles.cardsContainer}>
        <View style={styles.card}>
          <Text style={styles.cardText}>Mis estadísticas</Text>
        </View>
        <View style={styles.card}>
          <Text style={styles.cardText}>Mi tarifa</Text>
        </View>
        <View style={styles.card}>
          <Text style={styles.cardText}>Mis viajes</Text>
        </View>
        <View style={styles.card}>
          <Text style={styles.cardText}>Mis pagos</Text>
        </View>
      </View>

      {/* Imagen estática decorativa */}
      <View style={styles.staticImageContainer}>
        <Image 
          source={require('../../assets/images/registro.png')} 
          style={styles.staticImage}
          resizeMode="cover"
        />
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: Colors.background,
  },
  content: {
    alignItems: 'center',
    padding: 20,
    paddingTop: 40,
  },
  profileImage: {
    width: 120,
    height: 120,
    borderRadius: 60,
    marginBottom: 20,
    borderWidth: 3,
    borderColor: Colors.primary,
  },
  username: {
    fontSize: 24,
    fontWeight: 'bold',
    color: Colors.primary,
    marginBottom: 30,
    textAlign: 'center',
  },
  staticImageContainer: {
    width: '100%',
    height: 200,
    marginTop: 20,
    borderRadius: 10,
    overflow: 'hidden',
  },
  staticImage: {
    width: '100%',
    height: '100%',
  },
  cardsContainer: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    justifyContent: 'space-between',
    width: '100%',
    marginBottom: 20,
  },
  card: {
    width: '48%',
    height: 100,
    backgroundColor: Colors.secondary,
    borderRadius: 10,
    borderWidth: 1,
    borderColor: '#E0E0E0',
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: 10,
  },
  cardText: {
    fontSize: 14,
    color: Colors.text,
    fontWeight: '500',
  },
});

