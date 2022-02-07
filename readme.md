# Demo de Material Design en Android

## ¿Como hacer un PR?

1. Crea una rama de lo que quiereas hacer.

```
git branch <nombre_rama>
git checkout <nombre_rama>
```

2. Haz un commit en esa rama con los cambios que quieras hacer.

```
git add <fichero>
git commit -m <mensaje>
```

3. Envia tu nueva rama a tu fork de GitHub.

```
git push <mi_fork> <nombre_rama>
```

4. Ir a la pagina de GitHub y hacer un Pull Request.

5. Una vez aceptado el Pull Request, tenemos que borrar nuestra
rama temporal y actualizar nuestro repositorio a la ultima version.

```
git checkout master
git branch -d <nombre_rama>
git pull <remoto_central> master
```

