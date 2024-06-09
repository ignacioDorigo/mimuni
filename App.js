import { StatusBar } from 'expo-status-bar';
import React, { useEffect, useState } from 'react';
import { StyleSheet, Text, View, ScrollView, TouchableOpacity, Image } from 'react-native';
import axios from 'axios';

export default function App() {
  const [serviciosComercios, setServiciosComercios] = useState([]);
  const [serviciosProfesionales, setServiciosProfesionales] = useState([]);

  useEffect(() => {
    const fetchServiciosComercios = async () => {
      try {
        const response = await axios.get('http://192.168.0.241:8080/inicio/servicios/comercios');
        setServiciosComercios(response.data);
      } catch (error) {
        console.error('Error fetching comercios:', error);
      }
    };

    const fetchServiciosProfesionales = async () => {
      try {
        const response = await axios.get('http://192.168.0.241:8080/inicio/servicios/profesionales');
        setServiciosProfesionales(response.data);
      } catch (error) {
        console.error('Error fetching profesionales:', error);
      }
    };

    fetchServiciosComercios();
    fetchServiciosProfesionales();
  }, []);

  const renderCard = (servicio, index) => (
    <View key={index} style={styles.card}>
  {servicio.nombre !== undefined && (
    <View style={{flexDirection: "column"}}>
      <Text style={styles.cardText}><Text style={styles.boldText}>Responsable:</Text> {servicio.apellido + " " + servicio.nombre}</Text>
      <Text style={styles.cardText}><Text style={styles.boldText}>Horario:</Text> {servicio.horario}</Text>
      <Text style={styles.cardText}><Text style={styles.boldText}>Rubro:</Text> {servicio.rubro}</Text>
      </View>
  )}
  <Text style={styles.cardText}><Text style={styles.boldText}>Contacto:</Text> {servicio.contacto}</Text>

  <Text style={styles.cardText}><Text style={styles.boldText}>Descripción:</Text> {servicio.descripcion}</Text>
</View>

  );

  return (
    <View style={styles.container}>
      <StatusBar style="auto" />
      <View style={styles.header}>
        <View style={styles.headerSpacer}></View>
        <Text style={styles.headerTitle}>MiMuni</Text>
        <TouchableOpacity style={styles.headerIcon}>
          <Image source={require('./assets/BotonPersonita.png')} style={styles.iconImage} />
        </TouchableOpacity>
      </View>
      <ScrollView contentContainerStyle={styles.scrollView}>
        <Text style={styles.title}>Servicios</Text>
        <Text style={styles.subtitle}>Comercios</Text>
        {serviciosComercios.map((servicio, index) => renderCard(servicio, index))}
        <Text style={styles.subtitle}>Profesionales</Text>
        {serviciosProfesionales.map((servicio, index) => renderCard(servicio, index))}
      </ScrollView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#F2E9E4',
  },
  header: {
    backgroundColor: '#4A4E69',
    paddingTop: 50,
    paddingBottom: 20,
    paddingHorizontal: 15,
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 10,
  },
  headerSpacer: {
    width: 30,
  },
  headerTitle: {
    color: '#FFFFFF',
    fontSize: 26,
    fontWeight: 'bold',
    flex: 1,
    textAlign: 'center',
    paddingTop: 10,
  },
  headerIcon: {
    justifyContent: 'center',
    alignItems: 'center',
    paddingTop: 10,
  },
  iconImage: {
    width: 20,
    height: 20,
  },
  scrollView: {
    paddingHorizontal: 15,
  },
  title: {
    fontSize: 26,
    fontWeight: 'bold',
    marginVertical: 15,
    textAlign: 'center',
  },
  subtitle: {
    fontSize: 22,
    fontWeight: 'bold',
    marginVertical: 10,
  },
  card: {
    backgroundColor: '#8C7D85',
    borderRadius: 10,
    padding: 15,
    marginBottom: 20,
  },
  cardText: {
    color: '#FFF',
    marginBottom: 5,
  },
  boldText: {
    fontWeight: 'bold',
  },
});

