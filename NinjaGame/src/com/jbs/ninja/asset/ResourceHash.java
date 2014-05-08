package com.jbs.ninja.asset;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;

public class ResourceHash {
	static final Texture DEFAULT_TEXTURE = new Texture(1,1, Format.RGBA8888);
	static final AssetManager manager = new AssetManager();
	public static boolean ForceLoad = false;
	
	/* Texture Management:
	 * Contains useful texture creation and tracking methods below
	 */
	static HashMap<String,String> aliases = new HashMap<String,String>();
	/**Gets a path from resource alias
	 * aliases are prefixed with @ without it aliases are ignored
	 * @param alias 
	 * @return the aliases resource path
	 */
	public static String getAlias( String alias ) { 
		if(alias.startsWith("@")) return aliases.get( alias+":Texture" );
		return alias;
	}
	
	/**Sets an alias for a given resource path
	 * This is useful if we want to swap skins while still using the same aliases
	 * @param alias the new alias of the resource path
	 * @param resource the resource path
	 */
	public static void setAlias( String alias, String resource ) {
		aliases.put( "@"+alias+":Texture", resource );
	}
	
	/** Load a texture or gets a reference to a texture already loaded with the path
	 * @param resource file path to the texture
	 * @return default texture or a texture that already exists
	 */
	public static Texture loadTexture( String resource ) {

		if(!manager.isLoaded( resource, Texture.class )) {
			if( !Gdx.files.internal( resource ).exists() )
				{ System.err.println("File path does not exist: "+resource); return DEFAULT_TEXTURE; }
				
			manager.load( resource, Texture.class );
			if(ForceLoad) { 
				manager.finishLoading();
				return manager.get( resource, Texture.class );
			}
			return DEFAULT_TEXTURE;
		}
		return manager.get( resource, Texture.class );
	}
	
	/**Creates a new texture resource with the given path
	 * @param resource the resource path or an alias. aliases are prefixed with an @ symbol
	 * @return returns a new {@link TextureAsset} with the given resource path or alias.
	 */
	public static TextureAsset newTexture( String resource ) {
		TextureAsset tex = new TextureAsset();
		tex.textureID = resource;
		tex.update();
		return tex;
	}
	
	/**Set an alias to the resource path and creates a new texture resource
	 * @param resource the resource path or an alias. aliases are prefixed with an @ symbol
	 * @param alias the alias to give the path
	 * @return returns a new {@link TextureAsset} with the given resource path or alias.
	 */
	public static TextureAsset newTexture( String resource, String alias ) {
		aliases.put( "@"+alias+":Texture", resource );
		return newTexture( resource );
	}
	
}
