<template>
    <div>
        <div class="article" v-for="post in viewPosts" :key="post.id">
            <article>
                <div class="title">{{post.title}}</div>
                <div class="information">By {{post.user.login}}, 2 days ago, translation</div>
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
                        <a href="#">0</a>
                    </div>
                </div>
            </article>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Index",
        props: ['posts'],
        computed: {
            viewPosts: function () {
                return Object.values(this.posts).sort((a, b) => b.id - a.id)
            }
        }
    }
</script>

<style scoped>

</style>
