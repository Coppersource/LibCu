#include <libcu/lasershark.h>
#include <frc/DigitalInput.h>
#include <networktables/NTSendableBuilder.h>
#include <wpi/sendable/SendableRegistry.h>

namespace libcu
{

Lasershark::Lasershark(int channel)
    : pwmInput{std::make_shared<frc::DigitalInput>(channel)}
{
    wpi::SendableRegistry::Add(this, "Lasershark", pwmInput.GetFPGAIndex() + 1);
}

Lasershark::Lasershark(frc::DigitalSource &source)
    : pwmInput{source}
{
    wpi::SendableRegistry::Add(this, "Lasershark", pwmInput.GetFPGAIndex() + 1);
}

Lasershark::Lasershark(frc::DigitalSource *source)
    : pwmInput{source}
{
    wpi::SendableRegistry::Add(this, "Lasershark", pwmInput.GetFPGAIndex() + 1);
}

Lasershark::Lasershark(std::shared_ptr<frc::DigitalSource> source)
    : pwmInput{source}
{
    wpi::SendableRegistry::Add(this, "Lasershark", pwmInput.GetFPGAIndex() + 1);
}

units::foot_t Lasershark::GetDistance()
{
    return units::meter_t{pwmInput.GetOutput() * 4};
}

void Lasershark::InitSendable(nt::NTSendableBuilder &builder)
{
    builder.SetSmartDashboardType("Lasershark");
    builder.AddDoubleProperty("Distance (ft)",
                              [this] { return this->GetDistance().value(); }, nullptr);
}

} // namespace libcu
