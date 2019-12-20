# stabbr: twitter but sharp

This is a web application being designed by:
Vaidehi Paranjape
Kendra Ng
John (like I'm going to spell his whole name)
Kane Kopetski

To get started:
1. Clone the project
2. Run the application
  2a. The application is configured to launch locally with an in-mem H2 DB and on PCF with a PostgreSQL DB. The profile is select for you. To configure DB password and URL, see section Changing Environment Variables
3. Launch Postman
4. Register a new account using the signup endpoint defined below
5. Login using the login endpoint defined below
  5a. stabbr authenticates using JWT
7. You may now using any of the actuator, post, or comment endpoints defined below

Base local URL: localhost:4000
Base cloud URL:

# Authentication Endpoints:

------------------

Base endpoint:
/api/auth
Methods accepted: None

/signup
Methods accepted: POST
JSON Payload:
{
"username": "yourdesiredsernamehere",
"password": "yourdesiredpasswordhere",
"email": "youremailaddresshere"
}

/login
Methods accepted: POST
JSON Payload:
{
"username": "yourusernamehere",
"password": "yourpasswordhere",
}

------------------

### Post Endpoints:

------------------

/api/posts
Methods accepted: GET, POST, PUT

#####GET
Returns paginated list of all posts. Dynamically paged using URL params.

#####POST:
Creates a new post.
JSON Payload:
{
"title": "desiredtitlehere",
"content": "desiredcontenthere",
"username": "authenticatedusernamehere"
}

#####PUT:
Updates given post. Throws PostNotFoundException if post provided does not exist.
JSON Payload:
{
"postId": "idtoupdatehere",
"title": "desiredtitlehere",
"content": "desiredcontenthere",
"username": "authenticatedusernamehere"
}

------------------

/api/posts/:postId
Methods accepted: GET

#####GET
Return post with provided post ID.

------------------

/api/posts/delete/:postId
Methods accepted: DELETE

#####DELETE:
Delete post with provided post ID.

------------------

# Comment Endpoints

------------------

/api/comments
Methods accepted: GET, POST, PUT

#####GET
Returns paginated list of all comments. Dynamically paged using URL params.

#####POST:
Creates a new comment.
JSON Payload:
{
"postId": idhere,
"content": "desiredcontenthere",
"username": "authenticatedusernamehere"
}

#####PUT:
Updates given comments. Throws CommentNotFoundException if comment provided does not exist.
JSON Payload:
{
"commentId": "idtoupdatehere",
"content": "desiredcontenthere",
"username": "authenticatedusernamehere"
}

------------------

/api/comments/:commentId
Methods accepted: GET

#####GET
Return comment with provided comment ID.

------------------

/api/comments/delete/:commentId
Methods accepted: DELETE

#####DELETE:
Delete comment with provided comment ID.

------------------

/post/{postId}
Methods accepted: GET

#####GET
Returns comments associated with provided post ID.


