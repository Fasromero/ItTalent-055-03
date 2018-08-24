json.post do 
    json.id @post.id
    json.title @post.title
end

json.post do 
    json.body @post.body
end
