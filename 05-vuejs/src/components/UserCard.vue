<template>
  <v-card>
    <v-card-text>
      <div>Full name</div>

      <div class="text--primary">Address</div>
      <div class="text--primary">Date of birth</div>
    </v-card-text>
    <v-card-actions>
      <v-btn text color="warning"> Remove </v-btn>
      <v-btn text color="secondary"> Edit </v-btn>

    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  name: "UserCard",

  data: () => ({}),
};
</script>

<style>
</style>