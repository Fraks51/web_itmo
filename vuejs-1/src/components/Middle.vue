<template>
    <div class="middle">
<!--        <aside>-->
<!--            <SidebarPost v-for="post in viewPosts" :post="post" :users="users" :key="post.id"/>-->
<!--        </aside>-->
        <Sidebar :posts="posts" :users="users"/>
        <main>
            <Index v-if="page === 'Index'" :posts="posts" :comments="comments" :users="users"/>
            <Enter v-if="page === 'Enter'"/>
            <Register v-if="page === 'Register'"/>
            <AddPost v-if="page === 'AddPost'"/>
            <EditPost v-if="page === 'EditPost'"/>
            <ThisPost v-if="page === 'ThisPost'" :posts="posts" :comments="comments" :users="users"/>
            <Users v-if="page === 'Users'" :users="users"/>
        </main>
    </div>
</template>
<script>
    import Users from "./middle/Users";
    import Index from './middle/Index';
    import Enter from './middle/Enter';
    import Register from './middle/Register';
    import AddPost from './middle/AddPost';
    import Sidebar from './Sidebar';
    import EditPost from "./middle/EditPost";
    import ThisPost from "./middle/ThisPost";

    export default {
        name: "Middle",
        props: ['users', 'posts', 'comments'],
        data: function () {
            return {
                page: "Index"
            }
        },
        computed: {
            viewPosts: function () {
                alert(this.comment)
                return Object.values(this.posts).sort((a, b) => b.id - a.id).slice(0, 2);
            }
        },
        components: {
            ThisPost,
            Users,
            EditPost,
            Index,
            Enter,
            Register,
            AddPost,
            Sidebar
        }, beforeCreate() {
            this.$root.$on("onChangePage", (page) => {
                this.page = page;
            });
        }
    }
</script>

<style scoped>

</style>
