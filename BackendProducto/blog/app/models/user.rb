class User < ApplicationRecord
    #recibe muchos posts
    has_many :posts
    #convenciones cuando se usa de a muchos se incluye 's'
    validates :name, presence: true

end
