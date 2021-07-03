<template>
  <v-card>
    <v-img height="250" v-html="avatar"></v-img>

    <v-card-title
      >{{ fullName }}
      <div class="text-subtitle-1 grey--text ms-2">{{ age }} (years)</div>
    </v-card-title>

    <v-card-text>
      <div class="text-subtitle-1">{{ address }}</div>
    </v-card-text>

    <v-card-actions>
      <v-dialog v-model="dialog" width="500">
        <template v-slot:activator="{ on, attrs }">
          <v-btn text color="secondary" v-bind="attrs" v-on="on"> Edit </v-btn>
        </template>

        <!-- Edit user card-->
        <v-card>
          <v-card-title>Update a user</v-card-title>
          <v-card-text>
            <v-text-field
              label="First name"
              outlined
              v-model="userForm.firstName"
            ></v-text-field>

            <v-text-field
              label="Last name"
              v-model="userForm.lastName"
              outlined
            >
            </v-text-field>

            <v-textarea
              outlined
              prepend-inner-icon="mdi-home"
              label="Address"
              v-model="userForm.address"
            ></v-textarea>

            <v-menu
              ref="menu"
              v-model="menu"
              :close-on-content-click="false"
              :return-value.sync="userForm.dateOfBirth"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  outlined
                  v-model="userForm.dateOfBirth"
                  label="Date of birth"
                  prepend-inner-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker v-model="userForm.dateOfBirth" no-title scrollable>
                <v-spacer></v-spacer>
                <v-btn text color="primary" @click="menu = false">
                  Cancel
                </v-btn>
                <v-btn
                  text
                  color="primary"
                  @click="$refs.menu.save(userForm.dateOfBirth)"
                >
                  OK
                </v-btn>
              </v-date-picker>
            </v-menu>
          </v-card-text>

          <v-card-actions>
            <v-btn text color="warning" @click="dialog = false"> Cancel </v-btn>
            <v-btn text color="primary" @click="save(userForm)"> Save </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>

      <v-btn text color="warning" @click="removeUser(index)"> Remove </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import { generateFromString } from "generate-avatar";

export default {
  name: "UserCard",

  props: {
    index: Number,
    user: {
      type: Object,
      firstName: String,
      lastName: String,
      dateOfBirth: String,
      address: String,
    },
  },

  data: () => ({
    menu: false,
    dialog: false,
    userForm: {
      firstName: "",
      lastName: "",
      address: "",
      dateOfBirth: "",
    },
  }),

  created() {
    this.userForm = { ...this.user };
  },

  methods: {
    removeUser(index) {
      this.$emit("remove-user", index);
    },

    save(userForm) {
      this.$emit("update-user", { user: {...userForm}, index: this.index});
      this.dialog = false;

    }
  },

  computed: {
    fullName() {
      return this.user.firstName + " " + this.user.lastName;
    },

    address() {
      return this.user.address;
    },

       age() {
      return (
        new Date().getFullYear() - new Date(this.user.dateOfBirth).getFullYear()
      );
    },


    avatar() {
      return `${generateFromString(this.fullName)}`;
    },
  },
};
</script>

<style>
</style>