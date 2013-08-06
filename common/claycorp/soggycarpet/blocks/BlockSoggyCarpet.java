package claycorp.soggycarpet.blocks;

import claycorp.soggycarpet.utils.Archive;
import net.minecraft.block.BlockCarpet;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockSoggyCarpet extends BlockCarpet
{

	public BlockSoggyCarpet(final int id)
    {
        super(id);
        setCreativeTab(CreativeTabs.tabDecorations);
        setUnlocalizedName(Archive.MOD_ID_BLOCK + "soggycarpet");
        setHardness(5);
        setResistance(1000);
        setStepSound(soundSnowFootstep);
    }

  

	/**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool
     * has been
     * cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World world,
                                                         final int x,
                                                         final int y,
                                                         final int z)
    {
        return AxisAlignedBB.getAABBPool().getAABB(x + minX, y + minY, z + minZ, x + 1F, y + 0.25F, z + 1F);
    }
    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World worldID, int X, int Y, int Z, Entity slowEntity)
    {
        slowEntity.motionX *= 0.05D;
        slowEntity.motionZ *= 0.05D;
    }

}