<template>
    <div class="datatable">
        <div class="caption">Users</div>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Login</th>
                <th>Name</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="thisUser in viewUsers" :key="thisUser.id">
                <td>{{thisUser.id}}</td>
                <td>{{thisUser.login}}</td>
                <td>{{thisUser.name}}</td>
            </tr>
            <!--<User v-for="thisUser in viewUsers" :thisUser="thisUser" :key="thisUser.id"/>
            --></tbody>
        </table>
    </div>
</template>

<script>
    export default {
        name: "Users",
        props: ['users'],
        beforeCreate() {
            this.$root.$on("onChangePage", (page) => {
                this.page = page;
            });
        },
        computed: {
            viewUsers: function () {
                return Object.values(this.users).sort((a, b) => a.id - b.id);
            }
        }
    }
</script>

<style scoped>

</style>