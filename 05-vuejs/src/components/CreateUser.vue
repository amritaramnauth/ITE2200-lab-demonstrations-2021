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

    <v-col cols="2" sm="4" md="4" lg="2" v-for="user in users" :key="user.id">
      <UserCard
        :user="user"
        :index="user.id"
        @remove-user="removeUser"
        @update-user="updateUser"
      />
    </v-col>
  </v-row>
</template>

<script>
import UserCard from "./UserCard";
import axios from "axios";

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
    users: [],
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

  mounted() {
    axios.get("http://localhost:3000/users").then((response) => {
      this.users = response.data;
    });
  },

  methods: {
    create() {
      const user = { ...this.userForm };
      axios.post("http://localhost:3000/users", user).then((response) => {
        // re-fetch everything from GET /users
        this.users.push(response.data);
      });
    },

    removeUser(id) {
      axios.delete(`http://localhost:3000/users/${id}`).then(() => {
        this.users = this.users.filter((user) => user.id != id)
      })
    },

    updateUser($event) {
      var id = $event.index;
      var user = $event.user;

      axios.put(`http://localhost:3000/users/${id}`, user).then((response) => {
        this.users = this.users.map((user) => user.id != id ? user : response.data)
      })
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
