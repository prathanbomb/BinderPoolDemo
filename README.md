# BinderPoolDemo
https://codar.club/blogs/the-use-of-aidl-in-android-ii-binder-connection-pool.html


## Principle of Binder Connection Pool

The principle of a Binder connection pool is also well understood, that is, there is only one Service that returns a different Binder for different clients. This Binder connection pool is similar to a factory method pattern. Create the Binder objects they need for each client. Its working principle is shown in the following figure:

![AIDL connection pool](https://codar.club/images/blog/1ea1eddc3efc63ab017ec401853e44c9.jpg)
