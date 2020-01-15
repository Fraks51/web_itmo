<template>
    <div>
        <aside>
            <SidebarPost v-for="post in viewPosts" :post="post" :comments="comments" :users="users" :key="post.id"/>
        </aside>
    </div>
</template>


<script>
    import SidebarPost from './SidebarPost';

    export default {
        name: "Sidebar",
        props: ['users', 'posts', 'comments'],
        computed: {
            viewPosts: function () {
                return Object.values(this.posts).sort((a, b) => b.id - a.id).slice(0, 2);
            }
        },
        components: {
            SidebarPost
        }
    }
</script>

<style scoped>

</style>