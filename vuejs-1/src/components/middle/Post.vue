<template>
    <article>
        <div class="title">{{post.title}}</div>
        <div class="information">By {{user}}, 2 days ago, translation</div>
        <div class="body">
            {{post.text}}
        </div>
        <div class="footer">
            <div class="left">
                <img src="../../assets/img/voteup.png" title="Vote Up" alt="Vote Up"/>
                <span class="positive-score">+{{post.id}}</span>
                <img src="../../assets/img/votedown.png" title="Vote Down" alt="Vote Down"/>
            </div>
            <div class="right">
                <img src="../../assets/img/date_16x16.png" title="Publish Time" alt="Publish Time"/>
                2 days ago
                <img src="../../assets/img/comments_16x16.png" title="Comments" alt="Comments"/>
                <a href="#">{{commentsNum}}</a>
            </div>
        </div>
    </article>
</template>

<script>
    export default {
        name: "Post",
        props: ['post', 'users', 'comments'],
        computed: {
            user: function () {
                let thisUser = Object.values(this.users).filter((a) => a.id === this.post.userId);
                return thisUser[0].login;
            },
            commentsNum: function () {
                let thisComments = Object.values(this.comments).filter((a) => a.postId === this.post.id);
                return thisComments.length;
            }
        }
    }
</script>

<style scoped>

</style>