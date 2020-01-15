<template>
    <section>
        <div class="header">
            By {{users[post.userId].login}}
        </div>
        <div class="body">
            {{post.text}}
        </div>
        <div class="footer">
            <a href="#page=ThisPost" @click="changePage('ThisPost')">View All</a>
        </div>
    </section>

</template>

<script>
    export default {
        props: ['users', 'post', 'comments'],
        name: "SidebarPost",
        methods: {
            changePage: function (page) {
                this.$root.$emit("onChangePost", page, this.post, this.comments, this.users);
            }
        }
    }
</script>

<style scoped>

</style>
