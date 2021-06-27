<template>
  <v-row>
    <v-col cols="6" sm="10" md="8" lg="6">
      <v-card>
        <v-card-title>Create a user</v-card-title>
        <v-card-text>
          <v-text-field
            label="First name"
            outlined
            v-model="userForm.firstName"
          ></v-text-field>

          <v-text-field label="Last name" v-model="userForm.lastName" outlined>
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
              <v-btn text color="primary" @click="menu = false"> Cancel </v-btn>
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
          <v-btn :disabled="!valid" block large color="primary" @click="create">
            Create
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-col>

    <v-col cols="6" sm="10" md="8" lg="6">
      <v-data-table
        :headers="dataTableHeaders"
        :items="users"
        :items-per-page="5"
        class="elevation-1"
      ></v-data-table>
    </v-col>

    <v-col cols="3" sm="6" md="4" lg="3"> <UserCard /> </v-col>
  </v-row>
</template>

<script>
import UserCard from "./UserCard";

export default {
  components: {
    UserCard,
  },

  name: "CreateUser",

  data: () => ({
    menu: false,
    userForm: {
      firstName: "",
      lastName: "",
      address: "",
      dateOfBirth: "",
    },
    users: [
      {
        firstName: "Alan",
        lastName: "Turing",
        address: "123 Stabroek, Georgetown",
        dateOfBirth: new Date(1990, 11, 17).toLocaleDateString(),
      },
      {
        firstName: "Jane",
        lastName: "Doe",
        address: "2A Turkeyen, Greater Georgetown",
        dateOfBirth: new Date(2001, 12, 11).toLocaleDateString(),
      },
      {
        firstName: "Scrimply",
        lastName: "Pibbles",
        address: "221 East Street, South Cummingsburg",
        dateOfBirth: new Date(1972, 11, 17).toLocaleDateString(),
      },
      {
        firstName: "Freddie",
        lastName: "Doe",
        address: "9A New Market Street, Georgetown",
        dateOfBirth: new Date(2015, 11, 17).toLocaleDateString(),
      },
    ],
    dataTableHeaders: [
      {
        text: "First name",
        align: "start",
        sortable: true,
        value: "firstName",
      },
      { text: "Last name", value: "lastName" },
      { text: "Address", value: "address" },
      { text: "Date of birth", value: "dateOfBirth" },
    ],
  }),

  methods: {
    create() {
      const user = { ...this.userForm };
      this.users.push(user);
    },
  },

  computed: {
    valid() {
      return (
        Boolean(this.userForm.firstName) &&
        Boolean(this.userForm.lastName) &&
        Boolean(this.userForm.address) &&
        Boolean(this.userForm.dateOfBirth)
      );
    },
  },
};
</script>
