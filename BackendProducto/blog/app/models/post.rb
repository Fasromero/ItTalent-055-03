class Post < ApplicationRecord
  #pertenecen a los usuarios
  belongs_to :user
  validates :title, presence: true
  validates :body, presence: true
end
