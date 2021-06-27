<template>
  <v-app>
    <v-app-bar
      app
      color="secondary"
      dark
    > My App
    </v-app-bar>

    <v-main>
      <CreateUser/>
    </v-main>
    
  </v-app>
</template>

<script>
import CreateUser from './components/CreateUser';

export default {
  name: 'App',

  components: {
    CreateUser,
  },

  data: () => ({
    //
  }),
};
</script>
