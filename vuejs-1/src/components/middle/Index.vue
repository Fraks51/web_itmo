<template>
    <div>
        <Post v-for="post in viewPosts" :post="post" :users="users" :comments="comments" :key="post.id"/>
    </div>
</template>

<script>
    import Post from "./Post";
    export default {
        name: "Index",
        props: ['posts', 'comments', 'users'],
        computed: {
            viewPosts: function () {
                return Object.values(this.posts).sort((a, b) => b.id - a.id)
            }
        },
        components: {Post}
    }
</script>

<style scoped>

</style>
