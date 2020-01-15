<template>
    <div>
<!--        <article>-->
<!--            <div class="title">{{post.title}}}</div>-->
<!--            <div class="information">By {{user}}, 2 days ago, translation</div>-->
<!--            <div class="body">-->
<!--                {{post.text}}-->
<!--            </div>-->
<!--            <div class="footer">-->
<!--                <div class="left">-->
<!--                    <img src="../../assets/img/voteup.png" title="Vote Up" alt="Vote Up"/>-->
<!--                    <span class="positive-score">+{{post.id}}</span>-->
<!--                    <img src="../../assets/img/votedown.png" title="Vote Down" alt="Vote Down"/>-->
<!--                </div>-->
<!--                <div class="right">-->
<!--                    <img src="../../assets/img/date_16x16.png" title="Publish Time" alt="Publish Time"/>-->
<!--                    2 days ago-->
<!--                    <img src="../../assets/img/comments_16x16.png" title="Comments" alt="Comments"/>-->
<!--&lt;!&ndash;                    <a href="#">{{comments.length}}</a>&ndash;&gt;-->
<!--                </div>-->
<!--            </div>-->
<!--        </article>-->
    </div>
</template>

<script>
    export default {
        name: "ThisPost",
        props: ["post", "comments", "users"],
        beforeCreate() {
            this.$root.$on("onChangePost", (page, post, comments, user) => {
                this.page = page;
                this.comments = comments;
                this.user = user;
                this.post = post
            });
        },
    }
</script>

<style scoped>

</style>