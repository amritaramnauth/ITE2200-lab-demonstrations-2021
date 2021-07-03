<template>
  <v-card>
    <v-img height="250" v-html="avatar"></v-img>

    <v-card-title
      >Jane Doe
      <div class="text-subtitle-1 grey--text ms-2">21 (years)</div>
    </v-card-title>

    <v-card-text>
      <div class="text-subtitle-1">123 Test address</div>
    </v-card-text>

    <v-card-actions>
      <v-btn text color="secondary"> Edit </v-btn>
      <v-btn text color="warning"> Remove </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import { generateFromString } from "generate-avatar";

export default {
  name: "UserCard",

  data: () => ({}),
  computed: {

     avatar() {
      return `${generateFromString("Jane Doe")}`;
    },
  },

};
</script>

<style>
</style>