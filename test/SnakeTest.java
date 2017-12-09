import java.awt.Color;
import snake.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SnakeTest {
    
    public SnakeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    /**
     * Fonction pour vérifier la taille du tableau à deux dimensions
     */
    @Test
    public void fillArrayLengthTest(){
        //Act
        snake.Character.fillArray();
        //Assert
        assertEquals(snake.Character.obstacles.length,40);
        for(int i = 0 ; i < 40 ; i++){
            assertEquals(snake.Character.obstacles[i].length,40);
        }
    }
    
    /**
     * Fonction pour vérifier le type d'objets insérés dans le tableau
     */
    @Test
    public void fillArrayTypeTest() {
        //Append
        Obstacle o = new Obstacle(0,0,Color.WHITE);
        //Act
        snake.Character.fillArray();
        //Assert        
        for(int i = 0 ; i < 40 ; i++){
            for(int j = 0 ; j < 40 ; j++){
                assertTrue(snake.Character.obstacles[i][j] instanceof Obstacle || snake.Character.obstacles[i][j] == null);
            }
        }
    }
    
    /**
     * Fonction qui vérifie que la création de deux ennemies aux mêmes coordonnées est impossible
     */
    @Test
    public void createSameEnnemiesTest(){
        //Append
        int pos = 40;
        //Act
        boolean bool1 = snake.Character.createEnemy(pos,pos);
        boolean bool2 = snake.Character.createEnemy(pos,pos);
        //Assert
        assertTrue(bool1);
        assertFalse(bool2);
    }
    
    /**
     * Fonction qui vérifie que la création de deux ennemies à deux positions différentes est possible
     */
    @Test
    public void createEnnemiesTest(){
        //Append
        int posX = 40;
        int posY = 50;
        //Act
        boolean bool1 = snake.Character.createEnemy(posX,posY);
        boolean bool2 = snake.Character.createEnemy(posY,posX);
        //Assert
        assertTrue(bool1);
        assertTrue(bool2);
    }
}
