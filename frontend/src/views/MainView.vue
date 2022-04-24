<template>
  <div>
    <header>
      <h1>Weather Comparison</h1>
    </header>
    <h2 id="maph2">Select a location on the map!</h2>
    <div id="map">

    </div>
    <div class="accuweather">
      <h2>Accuweather</h2>
      <form class="accuweather-form">
        <div class="row">
          <div class="col">
            <label>Days</label>
            <select v-model="weatherAccuDate" class="form-control">
              <option>1</option>
              <option>5</option>
            </select>
          </div>
          <div class="col">
            <label for="latitudeAccu">Latitude</label>
            <input v-model="latLng.lat" type="text" class="form-control" id="latitudeAccu">
          </div>
          <div class="col">
            <label for="longitudeAccu">Longitude</label>
            <input v-model="latLng.lng" type="text" class="form-control" id="longitudeAccu">
          </div>
          <div class="col">
            <button type="button" class="btn btn-outline-info btn-lg" id="submit" v-on:click="getAccuweather">Get
              data!
            </button>
          </div>
        </div>
      </form>
      <table class="table table-hover table-sm" v-if="accuTableVisible">
        <thead>
        <tr>
          <th scope="col" style="width: 13%">Area</th>
          <th scope="col" style="width: 13%">Country</th>
          <th scope="col" style="width: 15%">Date/time</th>
          <th scope="col" style="width: 12%">Min temperature Cº</th>
          <th scope="col" style="width: 12%">Max temperature Cº</th>
          <th scope="col" style="width: 13%">Rain</th>
          <th scope="col" style="width: 13%">Description</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="report in weatherResponseAccu.weatherReportList">
          <td>{{ weatherResponseAccu.cityName }}</td>
          <td>{{ weatherResponseAccu.countryName }}</td>
          <td>{{ report.dateTime }}</td>
          <td>{{ report.minimumTemp }}</td>
          <td>{{ report.maximumTemp }}</td>
          <td>{{ report.rain }}</td>
          <td>{{ report.descriptionDay }}</td>
        </tr>
        </tbody>
      </table>
    </div>
    <div class="weatherApi">
      <h2>WeatherAPI</h2>
      <form class="weatherApi-form">
        <div class="row">
          <div class="col">
            <label>Days</label>
            <select v-model="weatherApiDate" class="form-control">
              <option selected>1</option>
              <option>2</option>
              <option>3</option>
            </select>
          </div>
          <div class="col">
            <label for="latitudeApi">Latitude</label>
            <input v-model="latLng.lat" type="text" class="form-control" id="latitudeApi">
          </div>
          <div class="col">
            <label for="longitudeApi">Longitude</label>
            <input v-model="latLng.lng" type="text" class="form-control" id="longitudeApi">
          </div>
          <div class="col">
            <button type="button" class="btn btn-outline-info btn-lg" v-on:click="getWeatherApi">Get
              data!
            </button>
          </div>
        </div>
      </form>
      <table class="table table-hover table-sm" v-if="apiTableVisible">
        <thead>
        <tr>
          <th scope="col" style="width: 13%">Area</th>
          <th scope="col" style="width: 13%">Country</th>
          <th scope="col" style="width: 15%">Date/time</th>
          <th scope="col" style="width: 12%">Min temperature Cº</th>
          <th scope="col" style="width: 12%">Max temperature Cº</th>
          <th scope="col" style="width: 13%">Rain</th>
          <th scope="col" style="width: 13%">Description</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="report in weatherResponseApi.weatherReportList">
          <td>{{ weatherResponseApi.cityName }}</td>
          <td>{{ weatherResponseApi.countryName }}</td>
          <td>{{ report.dateTime }}</td>
          <td>{{ report.minimumTemp }}</td>
          <td>{{ report.maximumTemp }}</td>
          <td>{{ report.rain }}</td>
          <td>{{ report.descriptionDay }}</td>
        </tr>
        </tbody>
      </table>
    </div>
    <div class="currentWeather">
      <h2>Current weather</h2>
      <form class="currentWeather-form">
        <div class="row">
          <div class="col">
            <select v-if="false" class="form-control">
            </select>
          </div>
          <div class="col">
            <label for="latitudeCurrent">Latitude</label>
            <input v-model="latLng.lat" type="text" class="form-control" id="latitudeCurrent">
          </div>
          <div class="col">
            <label for="longitudeCurrent">Longitude</label>
            <input v-model="latLng.lng" type="text" class="form-control" id="longitudeCurrent">
          </div>
          <div class="col">
            <button type="button" class="btn btn-outline-info btn-lg" v-on:click="getWeatherCurrent">Get
              data!
            </button>
          </div>
        </div>
      </form>
      <table class="table table-hover table-sm" v-if="currentTableVisible">
        <thead>
        <tr>
          <th scope="col" style="width: 13%">Area</th>
          <th scope="col" style="width: 13%">Country</th>
          <th scope="col" style="width: 15%">Date/time</th>
          <th scope="col" style="width: 24%">Temperature Cº</th>
          <th scope="col" style="width: 13%">Rain</th>
          <th scope="col" style="width: 13%">Description</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="weatherResponseCurrent in reportTableRows">
          <td>{{ weatherResponseCurrent.cityName }}</td>
          <td>{{ weatherResponseCurrent.countryName }}</td>
          <td>{{ weatherResponseCurrent.dateTime }}</td>
          <td>{{ weatherResponseCurrent.temperature }}</td>
          <td>{{ weatherResponseCurrent.rain }}</td>
          <td>{{ weatherResponseCurrent.descriptionDay }}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>

import axios from "axios";

export default {
  name: "MainView",
  data: function () {
    return {
      weatherResponseCurrent: {},
      weatherResponseAccu: {},
      weatherAccuDate: null,
      weatherResponseApi: {},
      weatherApiDate: null,
      accuTableVisible: false,
      apiTableVisible: false,
      currentTableVisible: false,
      reportTableRows: [],
      latLng: {
        lat: 59.436962,
        lng: 24.753574
      },
    }
  },

  methods: {
    getAccuweather: function () {

      this.$http.post("/accuweather", {
        dateRange: this.weatherAccuDate,
        latitude: this.latLng.lat,
        longitude:this.latLng.lng
      })
          .then(response => {
            this.weatherResponseAccu = response.data;
            this.accuTableVisible = true;
          })
          .catch(error => {
            console.log(error)
          })
    },
    getWeatherApi: function () {

      this.$http.post("/weatherapi", {
         dateRange: this.weatherApiDate,
        latitude: this.latLng.lat,
        longitude:this.latLng.lng
          }
      )
          .then(response => {
            this.weatherResponseApi = response.data
            this.apiTableVisible = true;
          })
          .catch(error => {
            console.log(error)
          })
    },
    getWeatherCurrent: function () {

      this.$http.post("/current", {
        latitude: this.latLng.lat,
        longitude:this.latLng.lng
      })
          .then(response => {
            this.weatherResponseCurrent = response.data
            this.currentTableVisible = true;
            console.log(this.weatherResponseCurrent)
            this.reportTableRows.push(this.weatherResponseCurrent);
          })
          .catch(error => {
            console.log(error.response.data)
          })
    }
  },
  mounted() {
    let mapOptions = {
      center: [58.876, 25.422],
      zoom: 5,
      draggable: true
    }

    let map = new L.map('map', mapOptions);

    let layer = new L.TileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png');
    map.addLayer(layer);

    let marker = new L.Marker([59.436962, 24.753574], {
      draggable: true,
      autoPan: true
    });
    marker.addTo(map);

    const self = this;

    marker.on('move', function () {
      self.latLng = marker.getLatLng();
    })
  }
}

</script>

<style scoped>
header {
  margin: 0;
  height: 20vh;
  width: auto;
  background-color: #a1d5e5;
}

header h1 {
  text-align: left;
  padding-left: 5vh;
  padding-top: 6vh;
  font-size: 3em;
}

h2 {
  background-color: bisque;
  text-align: left;
  padding-left: 11vh;
  padding-top: 3vh;
  padding-bottom: 3vh;
  margin-bottom: 3vh;
  font-size: 2em;
}
#maph2 {
  margin-bottom:0;
}

form {
  width: 40vw;
  margin-left: 5vw;
  margin-bottom: 3vh;
}

form button {
  margin-top: 15%;
}

.table table-hover {
  width: 70%;
}

#map {
  width: 100%;
  height: 50vh;
}
</style>