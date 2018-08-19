class CreateLocalidads < ActiveRecord::Migration[5.2]
  def change
    create_table :localidads do |t|
      t.string :nombre

      t.timestamps
    end
  end
end
