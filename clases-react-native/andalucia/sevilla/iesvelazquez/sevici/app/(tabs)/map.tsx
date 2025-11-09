import React, { useState } from 'react';
import { View, Text, StyleSheet, TouchableOpacity, Alert } from 'react-native';
import MapView, { Marker } from 'react-native-maps';
import { Colors } from '../../constants/colors';

export default function MapScreen() {
  const [bikeCount, setBikeCount] = useState(10); // Contador inicial de bicis disponibles

  // Coordenadas del IES Velázquez
  const iesVelazquezCoords = {
    latitude: 37.3825,
    longitude: -5.9822,
  };

  const handleReleaseBike = () => {
    if (bikeCount > 0) {
      setBikeCount(bikeCount - 1);
      Alert.alert(
        '¡Bicicleta liberada!',
        `Has liberado una Sevici. Quedan ${bikeCount - 1} bicicletas disponibles.`,
        [{ text: 'OK' }]
      );
    } else {
      Alert.alert(
        'Sin bicicletas',
        'No hay bicicletas disponibles en este momento.',
        [{ text: 'OK' }]
      );
    }
  };

  return (
    <View style={styles.container}>
      <MapView
        style={styles.map}
        initialRegion={{
          latitude: iesVelazquezCoords.latitude,
          longitude: iesVelazquezCoords.longitude,
          latitudeDelta: 0.01,
          longitudeDelta: 0.01,
        }}
      >
        <Marker
          coordinate={iesVelazquezCoords}
          title="IES Velázquez"
          description="Instituto de Educación Secundaria"
        />
      </MapView>

      {/* Toggle opcional para cambiar entre bicis y parking */}
      <View style={styles.toggleContainer}>
        <TouchableOpacity style={[styles.toggleButton, styles.toggleActive]}>
          <Text style={styles.toggleTextActive}>🚲</Text>
        </TouchableOpacity>
        <TouchableOpacity style={[styles.toggleButton, styles.toggleInactive]}>
          <Text style={styles.toggleTextInactive}>P</Text>
        </TouchableOpacity>
      </View>

      {/* Botones flotantes opcionales (refresh y centrar) */}
      <View style={styles.floatingButtons}>
        <TouchableOpacity style={styles.floatingButton}>
          <Text style={styles.floatingButtonText}>↻</Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.floatingButton}>
          <Text style={styles.floatingButtonText}>📍</Text>
        </TouchableOpacity>
      </View>

      {/* Botón Liberar una Sevici */}
      <View style={styles.buttonContainer}>
        <TouchableOpacity 
          style={styles.button}
          onPress={handleReleaseBike}
        >
          <Text style={styles.buttonText}>Liberar una SEVICI</Text>
        </TouchableOpacity>
        <Text style={styles.counterText}>Bicis disponibles: {bikeCount}</Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  map: {
    flex: 1,
  },
  buttonContainer: {
    position: 'absolute',
    bottom: 100,
    left: 0,
    right: 0,
    alignItems: 'center',
    paddingHorizontal: 20,
  },
  button: {
    backgroundColor: Colors.primary,
    paddingVertical: 15,
    paddingHorizontal: 30,
    borderRadius: 25,
    marginBottom: 10,
  },
  buttonText: {
    color: Colors.secondary,
    fontSize: 16,
    fontWeight: 'bold',
  },
  counterText: {
    color: Colors.text,
    fontSize: 14,
    fontWeight: '600',
  },
  toggleContainer: {
    position: 'absolute',
    top: 80,
    left: '50%',
    marginLeft: -60,
    flexDirection: 'row',
    backgroundColor: Colors.secondary,
    borderRadius: 20,
    overflow: 'hidden',
  },
  toggleButton: {
    paddingVertical: 8,
    paddingHorizontal: 20,
    minWidth: 60,
    alignItems: 'center',
  },
  toggleActive: {
    backgroundColor: Colors.primary,
  },
  toggleInactive: {
    backgroundColor: Colors.secondary,
  },
  toggleTextActive: {
    fontSize: 16,
  },
  toggleTextInactive: {
    fontSize: 16,
    color: Colors.text,
    fontWeight: 'bold',
  },
  floatingButtons: {
    position: 'absolute',
    right: 20,
    top: 100,
    gap: 10,
  },
  floatingButton: {
    width: 40,
    height: 40,
    borderRadius: 20,
    backgroundColor: Colors.secondary,
    justifyContent: 'center',
    alignItems: 'center',
    elevation: 3,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.25,
    shadowRadius: 3.84,
  },
  floatingButtonText: {
    fontSize: 18,
  },
});

